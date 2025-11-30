# Agrobank (Spring Boot + Svelte) Starter

This workspace contains a minimal Java Spring Boot backend (Postgres + JPA) and a Svelte frontend (Vite). Use Docker Compose to run Postgres locally.

Quick start (Windows / cmd.exe):

1) Start Postgres with Docker Compose:

```
docker compose up -d
```

2) Backend: from `backend/` run (requires JDK 17 and Maven):

```
cd backend
mvn spring-boot:run
```

The backend runs on `http://localhost:8080` and will auto-create tables in the `appdb` database.

3) Frontend: from `frontend/` run (requires Node.js/npm):

```
cd frontend
npm install
npm run dev
```

Open the frontend at `http://localhost:5173`. The frontend proxies `/api` to the backend.

Notes:
- Database credentials are in `backend/src/main/resources/application.properties`.
- If you prefer a different Postgres port or password, update `docker-compose.yml` and the properties file.
# Agrobank (Spring Boot + Svelte) Starter

This workspace contains a minimal Java Spring Boot backend (Postgres + JPA) and a Svelte frontend (Vite). Use Docker Compose to run Postgres locally.

Quick start (Windows / cmd.exe):

1) Start Postgres with Docker Compose:

```
docker compose up -d
```

2) Backend: from `backend/` run (requires JDK 17 and Maven):

```
cd backend
mvn spring-boot:run
```

The backend runs on `http://localhost:8080` and will auto-create tables in the `appdb` database.

3) Frontend: from `frontend/` run (requires Node.js/npm):

```
cd frontend
npm install
npm run dev
```

Open the frontend at `http://localhost:5173`. The frontend proxies `/api` to the backend.

Notes:
- Database credentials are in `backend/src/main/resources/application.properties`.
- If you prefer a different Postgres port or password, update `docker-compose.yml` and the properties file.
