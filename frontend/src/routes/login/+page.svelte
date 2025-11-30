<script lang="ts">
	import { Button } from '$lib/components/ui/button';
	import { login, register } from '$lib/api';
	let email = '';
	let password = '';
	let name = '';
	let message = '';
	let mode: 'login' | 'register' = 'login';

	async function submit() {
		message = '';
		try {
			if (mode === 'login') {
				await login(email, password);
				message = 'Logged in — token saved.';
			} else {
				await register(name, email, password);
				message = 'Registered — you can now log in.';
			}
		} catch (err) {
			const e = err as { error?: string };
			message = e?.error || JSON.stringify(e);
		}
	}
</script>

<svelte:head>
	<title>Login</title>
</svelte:head>

<main class="mx-auto my-8 flex max-w-sm flex-col gap-2">
	<h1 class="text-xl font-semibold">{mode === 'login' ? 'Login' : 'Register'}</h1>
	<form class="flex flex-col gap-2" on:submit|preventDefault={submit}>
		{#if mode === 'register'}
			<label class="flex flex-col gap-1">
				<span class="text-sm">Name</span>
				<input class="rounded border px-2 py-1" bind:value={name} name="name" />
			</label>
		{/if}

		<label class="flex flex-col gap-1">
			<span class="text-sm">Email</span>
			<input class="rounded border px-2 py-1" bind:value={email} name="email" type="email" />
		</label>

		<label class="flex flex-col gap-1">
			<span class="text-sm">Password</span>
			<input
				class="rounded border px-2 py-1"
				bind:value={password}
				name="password"
				type="password"
			/>
		</label>

		<div class="flex items-center gap-2">
			<Button type="submit">{mode === 'login' ? 'Log In' : 'Register'}</Button>
			<button
				type="button"
				class="h-9 rounded-md bg-secondary px-4 text-secondary-foreground shadow-xs hover:bg-secondary/80"
				on:click={() => (mode = mode === 'login' ? 'register' : 'login')}
			>
				{mode === 'login' ? 'Create account' : 'Have an account? Log in'}
			</button>
		</div>
	</form>

	{#if message}
		<p class="text-sm text-muted-foreground">{message}</p>
	{/if}
</main>
