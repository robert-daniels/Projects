// new : add a todo. list : list all to do's. delete: remove a todo, quit: quit app

let userAction;
let userInput;
let todoList = [];

while(userAction != 'quit'){
    userAction = window.prompt("What would you like to do? 'new' for new todo list item. 'list' to list your items, 'delete' to delete an item, 'quit' to quit app...")

    switch (userAction){
        case 'new': 
            userInput = window.prompt("Enter your new todo list item...");
            todoList.push(userInput);
            console.log(`${userInput} was added to your to do list`);
            break;
        case 'list':
            console.log("*******");
            for (let i = 0; i < todoList.length; ++i){
                console.log(`${i+1}. ${todoList[i]}`);
            }
            console.log("*******");
            break;
        case 'delete':
            userInput = window.prompt("Enter the item you wish to delete...");
            console.log(typeof userInput);
            let indexToDelete = todoList.indexOf(userInput);
            console.log(`Deleting ${todoList[indexToDelete]}...`);
            todoList.splice(indexToDelete,1);
            console.log("Deleted!");
            break;
        case 'quit':
            continue;
            break;
        
        default:
            console.log('unknown entry. please try again');
            break;
    }
}
    