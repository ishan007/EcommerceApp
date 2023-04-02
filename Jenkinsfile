pipeline {

    agent any

    stages{
        stage('Build'){

            steps{
                echo '---------- BUILD STAGE STARTED --------------'
                sh './gradlew build'
                sh 'ls  app/build/outputs/apk/release'
                echo 'Installing build on device for demo'
                sh '${ANDROID_HOME}/platform-tools/adb  install app/build/outputs/apk/release/app-release-unsigned.apk'
                echo '---------- BUILD STAGE FINISHED --------------'
            }
        }
    }

}

