pipeline {
    agent any

    stages {
        stage('Repo Klonla') {
            steps {
                echo 'Repository klonlandı'
            }
        }

        stage('Maven Build') {
            steps {
                dir('Alisveris-Sitesi---backend-main') {
                    bat 'mvn clean package'
                }
            }
        }
    }

    post {
        success {
            echo 'Build başarılı 🎉'
        }
        failure {
            echo 'Build başarısız ❌'
        }
    }
}
