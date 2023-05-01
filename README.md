# restaurants-reservations

Restaurant reservation application

Database schema: src/main/resources/schema.sql
Sample data: src/main/resources/data.sql (Default administrative user credentials: admin / 123456)

Database initialization: specify path to resources folder in InitializeDatabase class:
private static final String PATH_TO_RESOURCES = "";
and run InitializeDatabase application

Run RestaurantsReservationsWebApplication class to start application

Access http://127.0.0.1:8080/ to access restaurant visitors UI
Access http://127.0.0.1:8080/admin/restaurants to access admin UI (protected by the credentials mentioned above)

