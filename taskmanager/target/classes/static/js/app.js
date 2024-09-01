document.addEventListener("DOMContentLoaded", () => {
  const taskInput = document.getElementById("task-input");
  const addTaskButton = document.getElementById("add-task-button");
  const taskList = document.getElementById("task-list");

  function fetchTasks() {
    fetch("/api/tasks")
      .then((response) => response.json())
      .then((tasks) => {
        taskList.innerHTML = "";
        tasks.forEach((task) => {
          const taskItem = document.createElement("div");
          taskItem.className = "task-item";

          const taskTextNode = document.createElement("span");
          taskTextNode.textContent = task.description;
          taskItem.appendChild(taskTextNode);

          const deleteButton = document.createElement("button");
          deleteButton.textContent = "削除";
          deleteButton.addEventListener("click", () => {
            fetch(`/api/tasks/${task.id}`, { method: "DELETE" }).then(() =>
              fetchTasks()
            );
          });
          taskItem.appendChild(deleteButton);

          taskList.appendChild(taskItem);
        });
      });
  }

  addTaskButton.addEventListener("click", () => {
    const taskText = taskInput.value.trim();
    if (taskText === "") return;

    fetch("/api/tasks", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ description: taskText }),
    }).then(() => {
      taskInput.value = "";
      fetchTasks();
    });
  });

  fetchTasks();
});
