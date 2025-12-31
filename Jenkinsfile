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

        stage('Start Backend') {
            steps {
                bat '''
                start cmd /c mvn -f Alisveris-Sitesi---backend-main/northwind/pom.xml spring-boot:run
                timeout /t 20
                '''
            }
        }

        stage('Selenium UI Tests') {
            steps {
                bat 'mvn -f Alisveris-Sitesi---backend-main/northwind/pom.xml test -Pselenium'
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
