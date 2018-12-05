# Travelmore
Dit project is een applicatie in opdracht van [Realdolmen](https://www.realdolmen.com/nl). Het is een systeem om reizen te kunnen bekijken en boeken. 

## Installatie

Clone de repository

```
met SSH:
git clone git@github.com:TimSwerts/travelmore.git

met HTTPS:
git clone https://github.com/TimSwerts/travelmore.git
```


## API
Get transportmiddelen:
```
localhost:xxxx/travelmore/rest/transportmiddelen/getTransportmiddelen
```

Add transportmiddel:
```
localhost:xxxx/travelmore/rest/transportmiddelen/addTransportmiddel?naam=xxxx
```

Delete transportmiddel:
```
localhost:xxxx/travelmore/rest/transportmiddelen/deleteTransportmiddel?id=x&token=xxxx
```

DELETE acties zullen niet werken zonder user token!!

## Gebouwd met

* JSF Frontend framework
* JPA Backend framework
* SQL database

## Authors

* **Bram Bleys** - [BramBleys](https://github.com/BramBleys)
* **Bram Van Bergen** - [BramVanBergen](https://github.com/BramVanBergen)
* **Kim Moelants** - [KimMoelants](https://github.com/KimMoelants)
* **Robbert Van Hove** - [robbertvanhove](https://github.com/robbertvanhove)
* **Tim Swerts** - [TimSwerts](https://github.com/TimSwerts)
