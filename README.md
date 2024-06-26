<h1 align="center" style="font-weight: bold;">LectorVerso-micro 💻</h1>

<p align="center">
 <a href="#tech">Technologies</a> • 
 <a href="#started">Getting Started</a> • 
  <a href="#routes">API Endpoints</a> •
 <a href="#colab">Collaborators</a> •
 <a href="#contribute">Contribute</a>
</p>

<p align="center">
    <b>Simple description of what your project do or how to use it.</b>
</p>

<h2 id="technologies">💻 Technologies</h2>

- list of all technologies you used
- Java
- PostgresSQL
- Spring

<h2 id="started">🚀 Getting started</h2>

Here you describe how to run your project locally

<h3>Prerequisites</h3>

Here you list all prerequisites necessary for running your project. For example:

- [NodeJS](https://github.com/)
- [Git 2](https://github.com)

<h3>Cloning</h3>

How to clone your project

```bash
git clone https://github.com/VirosMs/LectorVerso-micro.git
```

<h3>Config .env variables</h2>

Use the `.env.example` as reference to create your configuration file `.env` with your AWS Credentials

```yaml
NODE_AWS_REGION=us-east-1
NODE_AWS_KEY_ID={YOUR_AWS_KEY_ID}
NODE_AWS_SECRET={YOUR_AWS_SECRET}
```

<h3>Starting</h3>

How to start your project

```bash
cd lectorverso-micro
```

<h2 id="routes">📍 API Endpoints</h2>

Here you can list the main routes of your API, and what are their expected request bodies.

| route           | description                                                     |                                     
|-----------------|-----------------------------------------------------------------|
| <kbd>USER</kbd> | Is a tag for user Endpoints [response details](#user-endpoints) |

<h2 id="user-endpoints">User Endpoints <kbd>/lv/api/u</kbd></h2>

| route                           | description                                                  |
|---------------------------------|--------------------------------------------------------------|
| <kbd>GET /user/n</kbd>          | retrieves user from name [more details](#get-user-by-name)   |
| <kbd>GET /user/e</kbd>          | retrieves user from email [more details](#get-user-by-email) |
| <kbd>POST /user/</kbd>          | create a new user [more details](#post-user)                 |
| <kbd>DELETE /user/delete/</kbd> | delete a user by email [more details](#delete-userdelete)    |

<h3 id="get-user-by-name">GET /user/n</h3>

*REQUEST*

```json
{
  "name": "VirosMortais",
  "password": "4444444"
}
```

*RESPONSE*

```json
{
  "id": 1,
  "name": "VirosMortais",
  "email": "her-email@gmail.com"
}
```

---
<h3 id="get-user-by-email">GET /user/e</h3>

**REQUEST**

```json
{
  "email": "her-email@gmail.com",
  "password": "4444444"
}
```

**RESPONSE**

```json
{
  "id": 1,
  "name": "VirosMortais",
  "email": "her-email@gmail.com"
}
```

---

<h3 id="post-user">POST /user/</h3>

**REQUEST**

```json
{
  "name": "VirosMortais",
  "email": "her-email@gmail.com",
  "password": "4444444"
}
```

**RESPONSE**

```json
{
  "httpStatus": 201
}
```

---

<h3 id="delete-userdelete">DELETE /user/delete/</h3>

**REQUEST**

```json
{
  "email": "her-email@gmail.com",
  "password": "4444444"
}
```

**RESPONSE**

```json
{
  "httpStatus": 200
}
```

---

<h2 id="colab">🤝 Collaborators</h2>

Special thank you for all people that contributed for this project.

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/94723454?s=400&u=9ad7cc78c23a0dab547be4e16a4b76ac4c263e27&v=4" width="100px;" alt="VirosMs profile picture"/><br>
        <sub>
          <b>VirosMs</b>
        </sub>
      </a>
    </td>

  </tr>
</table>

<h2 id="contribute">📫 Contribute</h2>

Here you will explain how other developers can contribute to your project. For example, explaining how can create their
branches, which patterns to follow and how to open an pull request

1. `git clone https://github.com/Fernanda-Kipper/text-editor.git`
2. `git checkout -b feature/NAME`
3. Follow commit patterns
4. Open a Pull Request explaining the problem solved or feature made, if exists, append screenshot of visual
   modifications and wait for the review!

<h3>Documentations that might help</h3>

[📝 How to create a Pull Request](https://www.atlassian.com/br/git/tutorials/making-a-pull-request)

[💾 Commit pattern](https://gist.github.com/joshbuchea/6f47e86d2510bce28f8e7f42ae84c716)