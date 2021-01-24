import React from 'react';
import  Listitem from "./Listitem" ;

class Todolist extends React.Component
{
    render()
    {
        const {todoList, duplicatehandler,filter, deletehandler,  toggleTodoMarkedhandler} = this.props;

        let showToDos = [];

        if (filter === "all")
        {
            showToDos = [...todoList];
        }

        if(filter === "completed")
        {
            for(let todo of todoList)
            {
                if(todo.completed===true) showToDos.push(todo);
            }
        }

        if(filter === "pending")
        {
            for(let todo of todoList)
            {
                if(todo.completed===false) showToDos.push(todo);
            }
        }
    
       console.log(todoList);
       console.log("showtodo", showToDos);

        return(
            <div class= "list-group mx-auto col-md-5">
                {showToDos ? showToDos.map(
                    (value,index) => {
                        return <Listitem key={index} task = {value} 
                        index={index}
                        deletehandler={deletehandler} 
                        duplicatehandler={duplicatehandler}
                        toggleTodoMarkedhandler={toggleTodoMarkedhandler}/> 
                    }
                    ) : ""
                }
            </div>
        );
    }
}


export default  Todolist;