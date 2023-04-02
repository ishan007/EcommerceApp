pipeline {

    agent any

    stages{
        stage('Build'){

            steps{
                echo '---------- BUILD STAGE STARTED --------------'
                sh './gradlew build'
                sh 'ls  app/build/outputs/apk/debug'
                echo 'Installing build on device for demo'
                sh '${ANDROID_HOME}/platform-tools/adb  install app/build/outputs/apk/debug/app-debug.apk'
                sh '${ANDROID_HOME}/platform-tools/adb shell am start -n "com.example.nagpecommerce/com.example.nagpecommerce.splash.SplashScreen" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER'
                echo '---------- BUILD STAGE FINISHED --------------'
            }
        }
    }

}

