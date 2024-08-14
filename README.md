все необходимые команды в случайном порядке для запуска приложения (тут только те команды которые тебе нужны сейчас)

BEFORE YOU START BUILDING YOUR CONTAINERS YOU HAVE TO DOWNLOAD POSTGRESQL IMAGE FROM DOCKERHUB(image name should be postgres because in docker-compose.yml i specified that it should be built from postgres image)

ALL THESE COMMANDS IN RANDOM SEQUENCE SO YOU CAN PRACTICE A LITTLE BIT

docker rmi <id>
docker images
docker rm <id>
docker ps
docker ps -a
docker-compose up --build
docker-compose up
docker-compose down

After you run application if everything is ok 

these are your endpoints to test

http://localhost:8092/test/hello_dulik   <------ this endpoint doesnt need an authentication (permited to all), I CALL THIS TEST ENDPOINT. YOU SHOULD RECEIVE STRING IN A RESPONSE

http://localhost:8092/authentication/login <------ BASIC AUTHENTICATION THROUGH USERNAME AND PASSWORD REQUIRED IN THIS ENDPOINT username="dulat", passwod="123", after succesful authentication you should get 200 ok http status, and JWT TOKEN as a string

last step to test everything is to pass your jwt token as BEARER and authenticate using token only, you can do it using endpoint below

http://localhost:8092/get_all_players <----- http status ok, example of response below=) for the simplicity :D
[
	{
		"id": 1,
		"userName": "dulat",
		"password": "123",
		"roles": []
	}
]
 ENJOY YOUR CODING SESSION :DDD
