pipeline {

    agent none
    tools{
        nodejs 'nodejs'
    }

    stages{
        stage('Build'){

            steps{
                echo '---------- BUILD STAGE STARTED --------------'
                sh './gradlew build'
                ls  app/build/outputs/apk/release
                echo '---------- BUILD STAGE FINISHED --------------'
            }
        }
    }

}

