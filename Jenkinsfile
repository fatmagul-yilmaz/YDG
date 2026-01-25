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
                bat 'mvn -f Alisveris-Sitesi---backend-main/pom.xml clean test'
            }
        }

        stage('Run System on Docker') {
            steps {
                bat 'cd Alisveris-Sitesi---backend-main && docker-compose up -d --build'
                sleep time: 30, unit: 'SECONDS' // Docker'ın kendine gelmesi için süreyi biraz artırdık
            }
        }

        stage('System Tests (Selenium + RestAssured)') {
            steps {
                // IT uzantılı sistem testlerini tetikler
                bat 'mvn -f Alisveris-Sitesi---backend-main/pom.xml verify -Psystem-tests'
            }
        }
    }

    post {
        always {
            junit '**/target/failsafe-reports/*.xml'
            junit '**/target/surefire-reports/*.xml'
            
            // Konteyner temizliği
            bat 'cd Alisveris-Sitesi---backend-main && docker-compose down'
        }
        success {
            echo '🎉 PIPELINE TAMAMEN BAŞARILI'
        }
        failure {
            echo '❌ PIPELINE HATA VERDİ'
        }
    }
}