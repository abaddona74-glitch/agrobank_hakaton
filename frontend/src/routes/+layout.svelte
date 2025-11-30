<script lang="ts">
	import '../app.css';
	let { children } = $props();
</script>

<div class="flex min-h-screen flex-col">
	<main class="mx-auto box-border flex w-full max-w-4xl flex-1 flex-col p-4">
		{@render children()}
	</main>
</div>
