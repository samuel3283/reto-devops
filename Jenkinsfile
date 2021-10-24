#!groovy?
def GIT_COMMIT_SHORT = ""

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
stage('Compilando con maven')
{
def mvnHome = tool 'jenkinsmvn';
sh "${mvnHome}/bin/mvn clean package"
}
stage('Construyendo Docker ') {
script{
sh "docker build -t repobackend:${GIT_COMMIT_SHORT} ."
}
}
stage('Iniciando Docker ') {
script{
sh "docker run -d -p 8085:8085 repobackend:${GIT_COMMIT_SHORT}"
}
}
}