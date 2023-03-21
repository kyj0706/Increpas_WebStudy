const all = ele => document.querySelectorAll(ele)
				const one = ele => document.querySelector(ele)
				const slide = _ => {
				  const wrap = one('.slide') // .slide 선택
				  const target = wrap.children[0] // .slide ul 선택
				  const len = target.children.length // .slide li 갯수
				  // .slide ul의 너비 조정
				  target.style.cssText = `width:calc(100% * ${len});display:flex;transition:1s`
				  // .slide li의 너비 조정
				  Array.from(target.children)
				  .forEach(ele => ele.style.cssText = `width:calc(100% / ${len});`)
				  // 화면 전환 실행
				  let pos = 0
				  setInterval(() => {
					pos = (pos + 1) % len // 장면 선택
					target.style.marginLeft = `${-pos * 100}%`
				  }, 2000) // 1500 = 1500ms = 1.5sec. 즉, 1.5초 마다 실행
				}
				window.onload = function () {
				  slide()
				}