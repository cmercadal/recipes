pipeline {
    agent any

    tools {
        maven "mvn386"
        jdk "java11"
    }

    environment {
        DISABLE_AUTH = true
    }

    stages {
        stage('Hello') {
            steps {
                echo "Initializing pipeline"
            }
        }
        stage("Git pulling"){
            steps {
                //git branch: 'master', url: 'https://github.com/cmercadal/time-tracker.git'
                 // Checkout the repository using SSH
                // git branch:'master', credentialsID
                checkout([$class: 'GitSCM',
                          branches: [[name: '*/main']],
                          userRemoteConfigs: [[url: 'git@github.com:cmercadal/recipes.git']],
                          extensions: [[$class: 'CleanBeforeCheckout']]])
            }
        }

        stage("Build con Maven"){
            steps{
                sh "mvn -Dmaven.test.failure.ignore=true clean install"
            }

            post{
                success{
                echo 'archivando artefactos'
                archiveArtifacts "target/*.jar"
                }
            }
        }

        stage("Test maven"){
            steps{
                sh "mvn test"
            }
        }

    }
}