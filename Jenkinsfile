pipeline {

    agent any

    stages{
        stage('Build'){

            steps{
                echo '---------- BUILD STAGE STARTED --------------'
                sh './gradlew build'
                sh 'ls  app/build/outputs/apk/release'
                echo 'Installing build on device for demo'
                sh 'adb  install app/build/outputs/apk/release/app-release-unsigned.apk'
                echo '---------- BUILD STAGE FINISHED --------------'
            }
        }
    }

}

