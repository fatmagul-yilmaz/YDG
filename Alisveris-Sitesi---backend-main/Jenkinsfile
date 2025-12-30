pipeline {
    agent any

    stages {

        stage('Repo Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/fatmagul-yilmaz/YDG.git'
            }
        }

        stage('Maven Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        success {
            echo 'Testler başarıyla çalıştı ✅'
        }
        failure {
            echo 'Testler başarısız ❌'
        }
    }
}
