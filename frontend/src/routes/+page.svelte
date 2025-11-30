<script lang="ts">
	// Home page: navbar with links to Login and Register
</script>

<svelte:head>
	<title>Home</title>
</svelte:head>

<header class="border-b">
	<nav class="mx-auto flex max-w-4xl items-center justify-between p-4">
		<a href="/" class="font-semibold">Agrobank</a>
		<div class="flex items-center gap-2">
			<a
				href="/login"
				class="rounded-md border px-3 py-1.5 hover:bg-accent hover:text-accent-foreground">Login</a
			>
			<a
				href="/register"
				class="rounded-md bg-primary px-3 py-1.5 text-primary-foreground hover:bg-primary/90"
				>Register</a
			>
		</div>
	</nav>
</header>

<main class="mx-auto max-w-4xl p-6">
	<h1 class="mb-2 text-2xl font-bold">Welcome</h1>
	<p class="text-muted-foreground">Choose an option from the navbar above.</p>
</main>
