## create

```bash
curl -X POST http://localhost:8080/inventory/create \
 -H "Content-Type: application/json" \
 -d '{
"id": "3",
"name": "Tablet",
"quantity": 15
}'
```

## search

```bash
curl -X GET "http://localhost:8080/inventory/search/3"
```

## add to cart

```
curl -X POST "http://localhost:8080/cart/add?productId=3&quantity=2"
```

## view cart

````
curl -X GET "http://localhost:8080/cart"
```
````
