<script lang="ts">
  // Home page: navbar with links to Login and Register
</script>

<svelte:head>
  <title>Home</title>
</svelte:head>

<header class="border-b">
  <nav class="max-w-4xl mx-auto flex items-center justify-between p-4">
    <a href="/" class="font-semibold">Agrobank</a>
    <div class="flex items-center gap-2">
      <a href="/login" class="px-3 py-1.5 rounded-md border hover:bg-accent hover:text-accent-foreground">Login</a>
      <a href="/register" class="px-3 py-1.5 rounded-md bg-primary text-primary-foreground hover:bg-primary/90">Register</a>
    </div>
  </nav>
  
</header>

<main class="max-w-4xl mx-auto p-6">
  <h1 class="text-2xl font-bold mb-2">Welcome</h1>
  <p class="text-muted-foreground">Choose an option from the navbar above.</p>
</main>

