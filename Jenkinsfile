node { 
   stage('SCM Pull') {
    git 'https://github.com/kumardil91/springboot'
   }
   stage('Build'){
   //Get maven home path 
   def mvnHome =  tool name: 'maven-3', type: 'maven'   
      sh "${mvnHome}/bin/mvn -Dmaven.test.skip=true clean package"
   }
   
   stage('Test') {
      def mvnHome =  tool name: 'maven-3', type: 'maven'
        sh "${mvnHome}/bin/mvn test -B"
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
      
   }
   stage("Build WAR") {
          sh "mvn clean package "
          stash name:"war", includes:"target/ROOT.war"
        }
    }
