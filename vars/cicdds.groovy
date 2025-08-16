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

  
