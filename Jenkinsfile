pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build + Unit + Integration Tests') {
            steps {
                // Burada klasörü doğru hedeflemişsiniz
                bat 'mvn -f Alisveris-Sitesi---backend-main/pom.xml clean test'
            }
        }

        stage('Run System on Docker') {
            steps {
                // HATA BURADAYDI: docker-compose.yml alt klasörde olduğu için klasöre girmelisiniz
                bat 'cd Alisveris-Sitesi---backend-main && docker-compose up -d --build'
                
                // Konteynerlerin hazır olması için bekleme
                bat 'timeout /t 20'
            }
        }

        stage('System Tests (RestAssured)') {
            steps {
                bat 'mvn -f Alisveris-Sitesi---backend-main/pom.xml test -Psystem-tests'
            }
        }
    }

    post {
        success {
            echo '🎉 PIPELINE TAMAMEN BAŞARILI'
        }
        failure {
            echo '❌ PIPELINE HATA VERDİ'
        }
        always {
            // HATA BURADAYDI: down komutu için de klasörün içine girmelisiniz
            // Aksi takdirde konteynerler açık kalır ve "not found" hatası alırsınız
            bat 'cd Alisveris-Sitesi---backend-main && docker-compose down'
        }
    }
}