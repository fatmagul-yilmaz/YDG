pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/fatmagul-yilmaz/YDG.git'
            }
        }

        stage('Build with Maven Wrapper') {
            steps {
                dir('Alisveris-Sitesi---backend-main') {
                    bat 'mvnw.cmd clean package -DskipTests'
                }
            }
        }
    }

    post {
        success {
            echo 'Maven build başarılı 🎉'
        }
        failure {
            echo 'Maven build başarısız ❌'
        }
    }
}
