# Shopping Cart
This code base models a simple Shopping Cart service consisting of a backend and frontend server.

The backend server is based on Java + SpringBoot + Gradle.

The frontend server is a React SPA.

# Setting up the Shopping Cart Service

### Requirements

```
yarn 1.21.1
java 1.8.0_242
npm 6.13.4
node 10.18.1
```

Note: Both servers are meant to be run on your local machine, due to hardcoded references.

### Backend Server

Run the following to setup and start the backend server.

```
git clone https://github.com/deejkstra/ShoppingCartBackEnd.git
cd ShoppingCartBackEnd
chmod +x ./gradlew
./gradlew build
./gradlew bootRun
```

Listens on port `8080`.

### Frontend Server

Run the following to setup and start the frontend server.

```
git clone https://github.com/deejkstra/ShoppingCartFrontEnd.git
cd ShoppingCartFrontEnd
yarn install
yarn build
yarn start
```

Listens on port `3000`

Note: some of the code isn't very clean because this was mostly developed in vim without style-rules.

# Using the Shopping Cart Service

### Browser

Both servers are meant to be run on `localhost` as the backend address is hardcoded in the frontend code. In the browser, go to `http://localhost:3000/` to view the main page of the site.

When you navigate to the site, you'll start on the main page.

Every page consists of two headers and a content section.

The first header has navigation links for Main, Shop, and Cart.

The second header show the current working Shopping Cart and Total Price.

The content section changes based on the current page.

### Main Page

This is the initial page of the App. From here the user can see all the shopping carts they've created.

You can create a new cart or select/click an existing one for shopping.

### Shopping Page

This page shows the inventory, prices, and discounts, and allows you to add items to your shopping cart, updating the Total Price.

### Cart Page

This page shows you the contents of your cart, the items you've selected and the quanitity.

The user has the option to clear the cart from this page.
