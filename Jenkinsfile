pipeline {
    agent any

    options {
        skipDefaultCheckout(true)
    }

    stages {

        stage('Checkout') {
            steps {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: '*/main']],
                    userRemoteConfigs: [[url: 'https://github.com/fatmagul-yilmaz/YDG.git']],
                    changelog: false,
                    poll: false
                ])
            }
        }

        stage('Build + Unit + Integration Tests') {
            steps {
                bat 'mvn -f Alisveris-Sitesi---backend-main/pom.xml clean verify -Pci'
            }
        }

        stage('Start Backend') {
            steps {
                bat '''
                start cmd /c mvn -f Alisveris-Sitesi---backend-main/pom.xml spring-boot:run
                timeout /t 20
                '''
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
            echo 'Pipeline BAŞARILI ✅'
        }
        failure {
            echo 'Pipeline HATALI ❌'
        }
    }
}
