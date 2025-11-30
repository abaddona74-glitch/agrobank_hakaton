// Ambient module declarations for shadcn-svelte
// This lets TypeScript accept importing the library's Svelte components
declare module 'shadcn-svelte' {
	// eslint-disable-next-line @typescript-eslint/no-explicit-any
	const content: any;
	export default content;
}

declare module 'shadcn-svelte/*' {
	// eslint-disable-next-line @typescript-eslint/no-explicit-any
	const content: any;
	export default content;
}
