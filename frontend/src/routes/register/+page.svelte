<script lang="ts">
  import { Button } from '$lib/components/ui/button';
  import { register } from '$lib/api';
  let name = '';
  let email = '';
  let password = '';
  let message = '';

  async function submit() {
    message = '';
    try {
      await register(name, email, password);
      message = 'Registered — you can now log in.';
    } catch (err) {
      const e = err as any;
      message = e?.error || JSON.stringify(e);
    }
  }
</script>

<svelte:head>
  <title>Register</title>
</svelte:head>

<main class="max-w-sm mx-auto my-8 flex flex-col gap-3">
  <h1 class="text-xl font-semibold">Create account</h1>
  <form class="flex flex-col gap-2" on:submit|preventDefault={submit}>
    <label class="flex flex-col gap-1">
      <span class="text-sm">Name</span>
      <input class="px-2 py-1 border rounded" bind:value={name} name="name" />
    </label>
    <label class="flex flex-col gap-1">
      <span class="text-sm">Email</span>
      <input class="px-2 py-1 border rounded" bind:value={email} name="email" type="email" />
    </label>
    <label class="flex flex-col gap-1">
      <span class="text-sm">Password</span>
      <input class="px-2 py-1 border rounded" bind:value={password} name="password" type="password" />
    </label>
    <div class="flex items-center gap-2">
      <Button type="submit">Register</Button>
      <a href="/login" class="px-3 py-1.5 rounded-md border hover:bg-accent hover:text-accent-foreground">Login</a>
    </div>
  </form>
  {#if message}
    <p class="text-sm text-muted-foreground">{message}</p>
  {/if}
</main>
