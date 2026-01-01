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
                bat 'mvn -f Alisveris-Sitesi---backend-main/pom.xml clean verify -Pci'
            }
        }

        stage('Run System on Docker') {
            steps {
                bat 'docker-compose up -d --build'
                bat 'timeout /t 20'
            }
        }

        stage('Selenium UI Tests') {
            steps {
                bat 'mvn -f Alisveris-Sitesi---backend-main/pom.xml test -Pselenium'
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
            bat 'docker-compose down'
        }
    }
}
