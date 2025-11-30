<script lang="ts">
	import { Button } from '$lib/components/ui/button';

	const news = [
		{
			id: 1,
			title: 'Agrobank & IT Community of Uzbekistan - AI500! 1-bosqich',
			date: '26-noyabr – 30-noyabr',
			summary:
				'Tabriklaymiz — siz 1-bosqichga o‘tdingiz! Birinchi vazifangiz — real hayotdagi bir muammoni tanlab, unga bo‘lgan IT-yechimingizni demo veb-sayt orqali taqdim etishdir.',
			content: `
				<p class="mb-2"><strong>Tabriklaymiz — siz 1-bosqichga o‘tdingiz!</strong></p>
				<p class="mb-4">Birinchi vazifangiz — real hayotdagi bir muammoni tanlab, unga bo‘lgan IT-yechimingizni demo veb-sayt orqali taqdim etishdir. Bu sizning g‘oyangiz qanchalik muhim masalani hal qilishi va jamoangiz uni yecha olishini ko‘rsatish uchun imkoniyatdir. Aynan shu bosqichdagi aniqlik — yakuniy taqdimot va mahsulotingizning asosini yaratadi.</p>
				
				<h3 class="text-lg font-semibold mt-4 mb-2">NIMA KIRITILISHI KERAK</h3>
				<p class="mb-2">Demo veb-saytingiz (hamma uchun ochiq) quyidagi bo‘limlarni o‘z ichiga olishi shart:</p>
				<ul class="list-disc pl-5 mb-4 space-y-2">
					<li><strong>1. Muammo va Yechim</strong><br>Muammo: Qaysi real muammoni hal qilmoqchisiz? Soha yoki yo‘nalishni ko‘rsating. Yechim: Sizning IT-mahsulot yoki xizmatingiz ushbu muammoni qanday hal qiladi?</li>
					<li><strong>2. Jamoa haqida ma’lumot</strong><br>Har bir jamoa a’zosi uchun: To’liq ism-familiya, Jamoadagi roli, Ko’nikmalari va texnologik stack.</li>
					<li><strong>3. Nega aynan sizning jamoangiz bu muammoni hal qila oladi</strong><br>Kuchli tomonlaringizni, tajribangizni va motivatsiyangizni ta’kidlang.</li>
					<li><strong>4. Yo‘l xaritasi & bosqich</strong><br>Rivojlanish rejangizni ko‘rsating. Hozirgi bosqichingizni belgilang: G‘oya / Prototip / MVP / Ishga tushirilgan.</li>
					<li><strong>5. Muammoni qanday hal qilmoqchisiz</strong><br>Muammoga qanday yondashishingiz va texnologiyangizni tushuntiring.</li>
				</ul>

				<h3 class="text-lg font-semibold mt-4 mb-2">QANDAY TOPSHIRISH</h3>
				<p class="mb-2">Oxirgi muddat: 30-noyabr, 23:59 (GMT+5)</p>
				<p class="mb-4">Telegram Bot orqali — Task 1 bo‘limini tanlab, havolani yuboring.</p>
			`
		}
	];
</script>

<svelte:head>
	<title>Yangiliklar</title>
</svelte:head>

<div class="container mx-auto py-8">
	<div class="mb-6 flex items-center justify-between">
		<h1 class="text-3xl font-bold">Yangiliklar</h1>
		<a href="/" class="text-primary hover:underline">Bosh sahifaga qaytish</a>
	</div>

	<div class="grid gap-6">
		{#each news as item}
			<div class="rounded-lg border bg-card p-6 text-card-foreground shadow-sm">
				<div class="mb-4 flex flex-col space-y-1.5">
					<h3 class="text-2xl leading-none font-semibold tracking-tight">{item.title}</h3>
					<p class="text-sm text-muted-foreground">{item.date}</p>
				</div>
				<div class="prose max-w-none dark:prose-invert">
					{@html item.content}
				</div>
			</div>
		{/each}
	</div>
</div>
