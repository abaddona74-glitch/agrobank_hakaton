<script lang="ts">
	import '../app.css';
	let { children } = $props();
</script>

<div class="flex flex-col min-h-screen">
	<main class="flex flex-1 flex-col p-4 w-full max-w-4xl mx-auto box-border">
		{@render children()}
	</main>
</div>

