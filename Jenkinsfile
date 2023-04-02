pipeline {

    agent none
    tools{
        nodejs 'nodejs'
    }

    stages{
        stage('Build'){
            agent {
                docker {
                    label 'docker'
                    image 'androidsdk/android-30'
                }
            }
            steps{
                echo '---------- BUILD STAGE STARTED --------------'
                sh './gradlew build'
                ls  app/build/outputs/apk/release
                echo '---------- BUILD STAGE FINISHED --------------'
            }
        }
    }

}

