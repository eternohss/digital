# digital

Para rodar o serviço o java deve estar instalado
junto com maven

acessar pacote e rodar o seguinte comando "mvn spring-boot:run"

o serviço estará disponivel na porta 8090
O mysql no com a conexão jdbc:mysql://localhost:3306/springboot
username=root
password=root

Deve ser criado as tabelas Pdv com os seguintes campos
number id;varchar tradingName; varchar ownerName; varchar document;

Deve ser criado as tabelas Coordinates com os seguintes campos
number id;varchar type; number latitude; number longitude; number fk pdv_id


O serviço é acessado no seguinte endereço 
localhost:8090/service/pdv
localhost:8090/service/pdv/{id}
localhost:8090/service/pdv/api/{lng}/{lat}
