export async function login(email: string, password: string) {
	const res = await fetch('http://localhost:8080/api/auth/login', {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({ email, password })
	});
	if (!res.ok) {
		const err = await res.json().catch(() => ({}));
		throw err;
	}
	const data = await res.json();
	if (data.token) {
		localStorage.setItem('token', data.token);
	}
	return data;
}

export async function register(name: string, email: string, password: string) {
	const res = await fetch('http://localhost:8080/api/auth/register', {
		method: 'POST',
		headers: { 'Content-Type': 'application/json' },
		body: JSON.stringify({ name, email, password })
	});
	const data = await res.json();
	if (!res.ok) throw data;
	return data;
}

export function getToken() {
	return typeof window !== 'undefined' ? localStorage.getItem('token') : null;
}

export function authFetch(input: RequestInfo, init?: RequestInit) {
	const token = getToken();
	init = init || {};
	init.headers = Object.assign(
		{},
		init.headers || {},
		token ? { Authorization: `Bearer ${token}` } : {}
	);
	return fetch(input, init);
}
