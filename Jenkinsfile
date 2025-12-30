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
                echo 'Maven build ve testler çalıştırılıyor...'
                bat 'mvnw.cmd clean verify'
            }
        }
    }

    post {
        success {
            echo 'Build ve testler BAŞARILI ✅'
        }
        failure {
            echo 'Build veya testlerde HATA ❌'
        }
    }
}
