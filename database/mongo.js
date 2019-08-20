/* 
1. simple find
 */

db.inventory.insertMany([
  {
    item: "journal",
    instock: [{ warehouse: "A", qty: 5 }, { warehouse: "C", qty: 15 }]
  },
  { item: "notebook", instock: [{ warehouse: "C", qty: 5 }] },
  {
    item: "paper",
    instock: [{ warehouse: "A", qty: 60 }, { warehouse: "B", qty: 15 }]
  },
  {
    item: "planner",
    instock: [{ warehouse: "A", qty: 40 }, { warehouse: "B", qty: 5 }]
  },
  {
    item: "postcard",
    instock: [{ warehouse: "B", qty: 15 }, { warehouse: "C", qty: 35 }]
  }
]);

// db.inventory.find( { 'instock.qty': { $lte: 20 } } )

db.inventory.insertMany([
  { item: "journal", qty: 25, tags: ["blank", "red"], dim_cm: [14, 21] },
  { item: "notebook", qty: 50, tags: ["red", "blank"], dim_cm: [14, 21] },
  {
    item: "paper",
    qty: 100,
    tags: ["red", "blank", "plain"],
    dim_cm: [14, 21]
  },
  { item: "planner", qty: 75, tags: ["blank", "red"], dim_cm: [22.85, 30] },
  { item: "postcard", qty: 45, tags: ["blue"], dim_cm: [10, 15.25] }
]);

// db.inventory.find( { tags: { $all: ["red", "blank"] } } )
// db.inventory.find( { tags: "red" } )

db.inventory.insertMany([
  { _id: 1, item: null },
  { _id: 2 },
  { _id: 3, item: "Chair" },
  { _id: 4, item: "Desk" },
  { _id: 5, item: "lamp" }
]);

// filter all with item null or no items

/* 
2) project value from embedded document
 */
db.inventory.insertMany([
  {
    item: "journal",
    status: "A",
    size: { h: 14, w: 21, uom: "cm" },
    instock: [{ warehouse: "A", qty: 5 }]
  },
  {
    item: "notebook",
    status: "A",
    size: { h: 8.5, w: 11, uom: "in" },
    instock: [{ warehouse: "C", qty: 5 }]
  },
  {
    item: "paper",
    status: "D",
    size: { h: 8.5, w: 11, uom: "in" },
    instock: [{ warehouse: "A", qty: 60 }]
  },
  {
    item: "planner",
    status: "D",
    size: { h: 22.85, w: 30, uom: "cm" },
    instock: [{ warehouse: "A", qty: 40 }]
  },
  {
    item: "postcard",
    status: "A",
    size: { h: 10, w: 15.25, uom: "cm" },
    instock: [{ warehouse: "B", qty: 15 }, { warehouse: "C", qty: 35 }]
  }
]);

// projections db.inventory.find( { status: "A" }, { item: 1, status: 1, _id: 0 } )
/* 
  db.inventory.find(
   { status: "A" },
   { item: 1, status: 1, "size.uom": 1 }
)
 */

/* 
 3) Update 
 */
db.inventory.insertMany([
  {
    item: "canvas",
    qty: 100,
    size: { h: 28, w: 35.5, uom: "cm" },
    status: "A"
  },
  { item: "journal", qty: 25, size: { h: 14, w: 21, uom: "cm" }, status: "A" },
  { item: "mat", qty: 85, size: { h: 27.9, w: 35.5, uom: "cm" }, status: "A" },
  {
    item: "mousepad",
    qty: 25,
    size: { h: 19, w: 22.85, uom: "cm" },
    status: "P"
  },
  {
    item: "notebook",
    qty: 50,
    size: { h: 8.5, w: 11, uom: "in" },
    status: "P"
  },
  { item: "paper", qty: 100, size: { h: 8.5, w: 11, uom: "in" }, status: "D" },
  {
    item: "planner",
    qty: 75,
    size: { h: 22.85, w: 30, uom: "cm" },
    status: "D"
  },
  {
    item: "postcard",
    qty: 45,
    size: { h: 10, w: 15.25, uom: "cm" },
    status: "A"
  },
  {
    item: "sketchbook",
    qty: 80,
    size: { h: 14, w: 21, uom: "cm" },
    status: "A"
  },
  {
    item: "sketch pad",
    qty: 95,
    size: { h: 22.85, w: 30.5, uom: "cm" },
    status: "A"
  }
]);

/* db.inventory.updateOne(
   { item: "paper" },
   {
     $set: { "size.uom": "cm", status: "P" },
     $currentDate: { lastModified: true }
   }
) */

/* 
4) Aggregation and look up
*/
db.orders.insert([
  { _id: 1, item: "almonds", price: 12, quantity: 2 },
  { _id: 2, item: "cashews", price: 20, quantity: 1 },
  { _id: 3, item: "pecans", price: 20, quantity: 3 },
  { _id: 4, item: "cashews", price: 20, quantity: 5 },
  { _id: 5, item: "pecans", price: 20, quantity: 52 },
  { _id: 6, item: "cashews", price: 20, quantity: 1 },
  { _id: 7, item: "pecans", price: 20, quantity: 34 },
  { _id: 8, item: "almonds", price: 20, quantity: 1 },
  { _id: 9, item: "pecans", price: 20, quantity: 12 },
  { _id: 10, item: "pecans", price: 20, quantity: 1 },
  { _id: 11, item: "almonds", price: 30, quantity: 5 },
  { _id: 12, item: "bread", price: 20, quantity: 56 }
]);
/* Total sales by items and list by highest to lowest */

db.inventory.insert([
  { _id: 1, sku: "almonds", description: "product 1", instock: 100 },
  { _id: 2, sku: "bread", description: "product 2", instock: 40 },
  { _id: 3, sku: "cashews", description: "product 3", instock: 80 },
  { _id: 4, sku: "pecans", description: "product 4", instock: 40 },
  { _id: 5, sku: null, description: "Incomplete" },
  { _id: 6 }
]);
/* Look up to inventory and find the whether the inventory has enough to cater to the order */
/* 
 Lookup:
 db.orders.aggregate([
   {
     $lookup:
       {
         from: "inventory",
         localField: "item",
         foreignField: "sku",
         as: "inventory_docs"
       }
  }
])
 */

db.billing.insertMany([
  {
    name: "joe",
    _id: 1,
    order_items: [
      { _id: 7, item: "pecans", price: 20, quantity: 34 },
      { _id: 8, item: "almonds", price: 20, quantity: 1 },
      { _id: 9, item: "pecans", price: 20, quantity: 12 },
      { _id: 10, item: "bread", price: 20, quantity: 1 },
      { _id: 11, item: "almonds", price: 30, quantity: 5 }
    ]
  },
  {
    name: "doe",
    _id: 2,
    order_items: [
      { _id: 7, item: "pecans", price: 20, quantity: 34 },
      { _id: 8, item: "almonds", price: 20, quantity: 1 },
      { _id: 9, item: "pecans", price: 20, quantity: 2 },
      { _id: 11, item: "almonds", price: 30, quantity: 3 }
    ]
  },
  {
    name: "Ted",
    _id: 3,
    order_items: [
      { _id: 7, item: "pecans", price: 20, quantity: 34 },
      { _id: 8, item: "almonds", price: 20, quantity: 1 },
      { _id: 9, item: "pecans", price: 20, quantity: 2 },
      { _id: 11, item: "almonds", price: 30, quantity: 3 }
    ]
  },
  {
    name: "doe",
    _id: 4,
    order_items: [
      { _id: 8, item: "almonds", price: 20, quantity: 50 },
      { _id: 9, item: "pecans", price: 20, quantity: 2 },
      { _id: 11, item: "almonds", price: 30, quantity: 1 }
    ]
  },
  {
    name: "Ted",
    _id: 5,
    order_items: [
      { _id: 9, item: "bread", price: 20, quantity: 20 },
      { _id: 11, item: "almonds", price: 30, quantity: 30 }
    ]
  }
]);

/* 
1. List of items purchased and the total quantity of items purchased
2. Sales by each customer
3. total sales
4. Max and min amount spent by each customer
5. Flatten the list such that the resultant list has nameOfcustomer,orderId,orderItem.
*/

db.warehouses.insert([
  { _id: 1, stock_item: "almonds", warehouse: "A", instock: 120 },
  { _id: 2, stock_item: "pecans", warehouse: "A", instock: 80 },
  { _id: 3, stock_item: "almonds", warehouse: "B", instock: 60 },
  { _id: 4, stock_item: "cookies", warehouse: "B", instock: 40 },
  { _id: 5, stock_item: "cookies", warehouse: "A", instock: 80 }
]);

/* 
  db.orders.aggregate([
   {
      $lookup:
         {
           from: "warehouses",
           let: { order_item: "$item", order_qty: "$ordered" },
           pipeline: [
              { $match:
                 { $expr:
                    { $and:
                       [
                         { $eq: [ "$stock_item",  "$$order_item" ] },
                         { $gte: [ "$instock", "$$order_qty" ] }
                       ]
                    }
                 }
              },
              { $project: { stock_item: 0, _id: 0 } }
           ],
           as: "stockdata"
         }
    }
])
  */

/* ------- Exercises for mongoose ------- */
/* 5) Build a pagination api for orders collections */
/* 6) Facebook schema with a few examples 
    Use normalised as well as denormalised tables
    Discuss and build schema. use schema validators 
    a. list all posts
    b. insert/update/delete posts
    c. insert/update/delete comments
    d. add users
    e. relation between users and posts
    f. relation between comments and posts
    h. Add indexing where necessary. Evaluate response time with and without indexing

  */
