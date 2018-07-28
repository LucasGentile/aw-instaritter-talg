

#Trabalho — APP InstaRitter (insta-ritter)   

## Grupo

* Alex Silveira  
* Lucas Gentile  
* Gelson Gonçalves  
* Tiago Xavier  

## HEROKU - Ambientes
* Dev    
https://dashboard.heroku.com/apps/insta-ritter-dev    
https://insta-ritter-dev.herokuapp.com/    

* Prod   
https://dashboard.heroku.com/apps/insta-ritter   
https://insta-ritter.herokuapp.com/    

## CIRCLECI - 
https://circleci.com/gh/tasima-uniritter/aw-instaritter-talg    
https://circleci.com/gh/tasima-uniritter/aw-instaritter-talg-service   
https://circleci.com/gh/tasima-uniritter/aw-instaritter-talg-client   

## Referências:   
https://github.com/mattia-battiston/clean-architecture-example    

## Instaritter MVAv0
	- Tecnologias:   
		- Java    
		- Spring   
		- Thymeleaf   
		- Banco H2   
	- Arquitetura   
		- Monolito   
		- Multi camadas simple
	- Features (Monolito):   
		- API: Funcionalidade de Persistir uma imagem   
		- API: Funcionalidade de Obter uma imagem   
		- Front: Upload da imagem   
		- Front: Visualizar a imagem por id   
	- Deploy   
		- Manter no GITHUB   
		- Deploy automatico no Heroku

![](https://lh3.googleusercontent.com/znBVXfPvhYyXVHWOZME9b0F2PzscsHZ_OtaAX5Qx7SoUhIwprpUeXgQRZ0M9GvAAXn09tdLPk5oT)

## Instaritter MVAv1     
	- Tecnologias:   
		- Java    
		- Spring   
		- Thymeleaf   
		- Mysql   
	- Arquitetura   
		- front   
		- Clean   
	- Features:   
		- API (Microservices):   
			- Funcionalidade de Persistir uma imagem   
			- Funcionalidade de Obter uma imagem   
			- Funcionalidade de lista de imagens   
		- Front :    
			- Upload da imagem   
			- Lista de imagens   
	- Deploy   
		- Manter no GITHUB   
		- Deploy no AWS (avaliar Custo)   

	- Custo AWS: U$ 692.24	

![](https://lh3.googleusercontent.com/bEHBVVsqsPx3HYhUYoFgGJE1pioI_ALGi0i6ezEJzDg9hnmmIg75pV5MBnXsUBqIvvoh-4HYNlih)
  
## Instaritter MVAv2   
	- Tecnologias:    
		- Java    
		- Spring    
		- Thymeleaf    
		- Mysql    
	- Arquitetura    
		- Microservices    
		- Clean    
	- Features:    
		- API (Microservices):     
			- Funcionalidade de Persistir uma imagem    
			- Funcionalidade de Obter uma imagem    
		- Front :      
			- Upload da imagem (Imagem em sí no FileSysteam ao invés de utilizar o DB)   
			- Lista de imagens    
	- Deploy    
		- Manter no GITHUB    
		- Deploy no AWS    
		- Use Load balance

	- Custo AWS: U$ 728.39    

		- https://www.statuspage.io/    
		- Autenticação - https://auth0.com/   
		- Docker - https://aws.amazon.com/pt/ecs/   

![](https://lh3.googleusercontent.com/rGGHVpU2JWL4nmeT8XSCNFZtLKnyHXaoFoKwfJ3yiw9K1FpW2VjegF6V8mANcNCEDVhZFCgU_bH5)
