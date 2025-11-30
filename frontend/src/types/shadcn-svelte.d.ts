// Ambient module declarations for shadcn-svelte
// This lets TypeScript accept importing the library's Svelte components
declare module 'shadcn-svelte' {
    const content: any;
    export default content;
}

declare module 'shadcn-svelte/*' {
    const content: any;
    export default content;
}
