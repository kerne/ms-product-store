## Falabella Evaluation short

PRUEBA TECNICA - API REST

##REPOSITORIO GITHUB

git clone https://github.com/kerne/ms-product-store.git

##ENDPOINTS
/api/v1/product

POST -> Body 
{
"sku": 8406270,
"name" : "500 Zapatilla Urbana Mujer",
"brand" : "NEW BALANCE",
"size" : 37,
"price": 42999,
"principalUrl": "https://falabella.scene7.com/is/image/Falabella/8406270_1",
"otherUrls":[
        {"name" : "https://falabella.scene7.com/is/image/Falabella/8406270_1"}
]
}

## CORRER APLICACIÓN

gradle bootRun
