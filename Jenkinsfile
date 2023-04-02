pipeline {

    agent any

    stages{
        stage('Build'){

            steps{
                echo '---------- BUILD STAGE STARTED --------------'
                sh './gradlew build'
                echo '---------- BUILD STAGE FINISHED --------------'
            }
        }
    }

}

