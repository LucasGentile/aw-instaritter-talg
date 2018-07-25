
#Trabalho — APP Insta Ritter (insta-ritter)   

## Grupo

* Alex Silveira  
* Lucas Gentile  
* Gelson Gonçalves  
* Tiago Xavier  

## HEROKU
* Dev    
https://dashboard.heroku.com/apps/insta-ritter-dev    
https://insta-ritter-dev.herokuapp.com/    

* Prod   
https://dashboard.heroku.com/apps/insta-ritter   
https://insta-ritter.herokuapp.com/    

## Referências:   
https://github.com/mattia-battiston/clean-architecture-example    

— 

## MVA (v0)   
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

![](https://lh3.googleusercontent.com/qLK9NfS9zCkQtIfCj3WR0CLZAIoMbi61k16V7e6JEhQdkUL3WM-3lEM8U_G-qh_8gKFxbC4weebg)

## MVA (v1)     
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

![](https://lh3.googleusercontent.com/bEHBVVsqsPx3HYhUYoFgGJE1pioI_ALGi0i6ezEJzDg9hnmmIg75pV5MBnXsUBqIvvoh-4HYNlih)
  
## MVA (v2)   
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
			- Funcionalidade de lista de imagens     
		- Front :      
			- Upload da imagem    
			- Lista de imagens    
	- Deploy    
		- Manter no GITHUB    
		- Deploy no AWS    
		- Use Load balance    
    
    
		- https://www.statuspage.io/    
		- Autenticação - https://auth0.com/   
		- Docker - https://aws.amazon.com/pt/ecs/   
