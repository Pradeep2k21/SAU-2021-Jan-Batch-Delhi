import React from 'react';

class Listitem extends React.Component{
    
    render(){
        const {task, index, deletehandler, duplicatehandler, toggleTodoMarkedhandler} = this.props;
        console.log(task);
        return(
            <label>
                <div style = {{padding:'2px', margin:'5px'}}>
                    <input class="checkbox"
                        type="checkbox"
                        checked = {task.completed}
                        onChange = {()=>toggleTodoMarkedhandler(index)}/>
                    <span style={task.completed ? {textDecoration:'line-through'}:{}}>{task.task}</span>
                    <button onClick={() => deletehandler(index)}>Delete</button>
                    <button onClick={() => duplicatehandler(index)}>Duplicate </button>            
                </div>
            </label>
        );
    }
}

export default Listitem;