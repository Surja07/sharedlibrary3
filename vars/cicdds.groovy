def gitdownload (repo)
{
  git branch: 'main', url: "https://github.com/Surja07/${repo}.git"
}
def build()
{
    sh "mvn clean package"
}
def deployment(jobname,ip)
{  
  sh "scp /var/lib/jenkins/workspace/${jobname}/HelloWorld.java ubuntu@${ip}:/home/ubuntu/demo4"
}

def test(jobname)
{  
  sh """
    javac /var/lib/jenkins/workspace/${jobname}/HelloWorld.java
    java -cp /var/lib/jenkins/workspace/${jobname} HelloWorld > /var/lib/jenkins/workspace/${jobname}/test_output.txt
"""
}



  
