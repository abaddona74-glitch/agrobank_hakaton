# CI/CD Setup

## Workflows

- `/.github/workflows/ci.yml`
  - Backend: Java 17 + Maven tests
  - Frontend: pnpm install, lint, build

- `/.github/workflows/deploy.yml`
  - Trigger: push to `main`
  - Steps: build artifacts, rsync repo to server, `docker compose up -d`

## Server (Ubuntu) Preparation

1. Install Docker and Compose
   - `curl -fsSL https://get.docker.com | sh`
   - `sudo usermod -aG docker $USER` (re-login required)
2. Create deploy directory
   - `sudo mkdir -p /opt/agrobank && sudo chown $USER:$USER /opt/agrobank`
3. GitHub Secrets (Repo → Settings → Secrets → Actions)
   - `DEPLOY_HOST`: e.g., `158.180.16.243`
   - `DEPLOY_USER`: e.g., `ubuntu`
   - `DEPLOY_SSH_KEY`: private key content for SSH (paste full PEM: `-----BEGIN ... PRIVATE KEY-----` ... `-----END ... PRIVATE KEY-----`)
   - `GH_TOKEN`: GitHub PAT (fine‑grained or classic) with at least `repo:read` for private checkout

## Manual Deploy Commands

```
ssh -i connect.key ubuntu@158.180.16.243
cd /opt/agrobank/agrobank_hakaton
docker compose up -d --build
docker compose logs -f
```
