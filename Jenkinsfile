#!groovy?
def GIT_COMMIT_SHORT = ""
def mvnHome = tool 'jenkinsmvn';

node {
deleteDir()

stage('Descargar Fuentes') {
checkout scm
script {
    GIT_COMMIT = sh (
        script: 'git rev-parse HEAD',
        returnStdout: true
    ).trim()
    GIT_COMMIT_SHORT = GIT_COMMIT.substring(0,8)
}
  
}

stage('Build')
{	
sh "${mvnHome}/bin/mvn package -Dmaven.test.skip=true"
}

stage('Test')
{	
sh "${mvnHome}/bin/mvn test"
junit "reports/**/*.xml"
}

stage('Deploy') {
script{
sh "docker build -t repobackend:${GIT_COMMIT_SHORT} ."
sh "docker run -d -p 8085:8085 repobackend:${GIT_COMMIT_SHORT}"
}

}

stage('Functional Test') {
script{
sh "echo Finalizando"
}
}

}