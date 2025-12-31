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
                bat 'mvn -f Alisveris-Sitesi---backend-main/northwind/pom.xml clean verify -Pci'
            }
        }

        stage('Selenium UI Tests') {
            steps {
                bat 'mvn -f Alisveris-Sitesi---backend-main/northwind/pom.xml clean verify -Pselenium'
            }
        }
    }

    post {
        success {
            echo 'Pipeline BAŞARILI ✅'
        }
        failure {
            echo 'Pipeline HATALI ❌'
        }
    }
}
