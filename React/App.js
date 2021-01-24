
import './App.css';
import React from 'react';
import Todolist from "./components/Todolist";
// import { render } from '@testing-library/react';


class App extends React.Component {

  state = {
    inputFieldValue:"",
    todoList : [{task:"Create a Todo List", completed:false}],
    filter : "all"
  };

 
  deletehandler = (index) => {
    const {todoList} = this.state;
    let temp = [...todoList];
    temp.splice(index,1);
    this.setState({todoList:temp});
  }

  duplicatehandler = (index) => {
    const {todoList} = this.state;
    let temp = [...todoList];
    temp.push({task:temp[index].task, completed:false})
    this.setState({todoList:temp});
  }




  toggleTodoMarkedhandler = (index) => {
    const todos = this.state.todoList;
    let newTodos = [...todos];

    newTodos[index] = {
        ...newTodos[index],
        completed: !newTodos[index].completed
    } ;
    this.setState({todoList: newTodos});
  }

  displayAll = () => {
    this.setState({filter: "all"});
  }

  Completedhandler = () => {
    this.setState({filter: "completed"});
  }

  Pendinghandler = () => {
    this.setState({filter: "pending"});
  }

  updateInputField = (event) => {
    this.setState({inputFieldValue:event.target.value});
  } 

  addTodo = () => {
    const {inputFieldValue, todoList} = this.state;

    let newTodos = [...todoList];
    if(inputFieldValue !== "")
    {   newTodos.push({task:inputFieldValue, completed:false});
        this.setState({todoList:newTodos, inputFieldValue:""});
    }
  }
  render(){
    return (
      <div className="todo-container">
        <h1>Todo List</h1>
        <input type="text" value={this.state.inputFieldValue} onChange={this.updateInputField} placeholder="Enter Task"/>
        <button class="button" onClick = {this.addTodo}>Add Todo</button>
        <button onClick = {this.displayAll}>Display All Tasks</button>
        <button onClick = {this.Completedhandler}>Complete Tasks</button>
        <button onClick = {this.Pendinghandler}>Pending Tasks</button>
        <Todolist todoList = {this.state.todoList}
        filter = {this.state.filter}
        deletehandler = {this.deletehandler}
        duplicatehandler = {this.duplicatehandler}
        toggleTodoMarkedhandler = {this.toggleTodoMarkedhandler} />
      </div>
    );
  }
}

export default App;
