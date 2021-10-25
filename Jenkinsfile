#!groovy?
def GIT_COMMIT_SHORT = ""
def mvnHome = ""

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
stage('Test')
{
mvnHome = tool 'jenkinsmvn'
sh "${mvnHome}/bin/mvn package -Dmaven.test.skip=true"
}
stage('Test')
{
mvnHome = tool 'jenkinsmvn'
sh "${mvnHome}/bin/mvn test"
junit 'target/surefire-reports/*.xml'
}
stage('Deploy') {
script{
//sh "docker stop --time=300 $(docker ps -aq)"
sh "docker build -t repobackend:${GIT_COMMIT_SHORT} ."
sh "docker run -d -p 8085:8085 repobackend:${GIT_COMMIT_SHORT}"
}
}
stage('Functional Test') {
script{
sh "/usr/share/jmeter/bin/jmeter -Jjmeter.save.saveservice.output_format=xml -n -t Test.jmx || exit 0"
}
}
}