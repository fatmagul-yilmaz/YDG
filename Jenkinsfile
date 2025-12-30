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
                    userRemoteConfigs: [[
                        url: 'https://github.com/fatmagul-yilmaz/YDG.git'
                    ]],
                    doGenerateSubmoduleConfigurations: false,
                    extensions: [
                        [$class: 'CleanBeforeCheckout'],
                        [$class: 'CloneOption', noTags: true, shallow: false, depth: 0]
                    ]
                ])
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
