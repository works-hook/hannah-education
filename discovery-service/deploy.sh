./gradlew bootBuildImage

ssh -i ~/.ssh/hannah-education.pem ubuntu@3.35.249.142 "~/education-front/discovery-service-deploy.sh"
