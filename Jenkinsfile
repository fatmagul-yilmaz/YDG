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
                // Jenkins dostu bekleme komutu
                sleep time: 20, unit: 'SECONDS'
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
            bat 'cd Alisveris-Sitesi---backend-main && docker-compose down'
        }
    }
}